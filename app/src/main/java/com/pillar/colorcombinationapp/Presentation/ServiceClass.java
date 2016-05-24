package com.pillar.colorcombinationapp.Presentation;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.pillar.colorcombinationapp.Model.ColorChipsClass;

import java.util.ArrayList;
import java.util.HashMap;


public class ServiceClass {

    private Context context;
    private String beginMarker = "";
    private String endMarker = "";
    private String findNextPair = "";
    private String output = null;
    int flag = 0;
    final private String CANNOT_UNLOCK_MASTER_PANEL = "Cannot unlock master panel";

    private HashMap<String, ArrayList<ColorChipsClass>> colorChipsMap = new HashMap<>();

    public ServiceClass(Context context) {
        this.context = context;
    }

    public void start(String input) {

        String[] pairs = input.split(" ");
        breakdownBeginAndEndMarkers(pairs[0]);
        breakdownColorChips(pairs);
        arrangeSequence();

        if (output.startsWith(beginMarker) && output.endsWith(endMarker)) {

            showOutputDialog(output);
            Log.d("output", output);
        } else {
            output = CANNOT_UNLOCK_MASTER_PANEL;
            showOutputDialog(output);
            Log.d("output", CANNOT_UNLOCK_MASTER_PANEL);
        }
    }

    private void showOutputDialog(String output) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.context);

        alertDialog.setTitle("Output");
        alertDialog.setMessage(output);

        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.show();
    }

    private void arrangeSequence() {

        while (colorChipsMap.size() > 0) {
            if (flag == 0)
                findColorPair(findNextPair);
            else
                break;
        }
    }

    private void findColorPair(String findNext) {

        if (colorChipsMap.containsKey(findNext)) {
            ArrayList<ColorChipsClass> list = colorChipsMap.get(findNext);

            if (list.size() > 1) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getEndColor().equals(this.endMarker))
                        continue;
                    else {

                        if (output != null) {
                            output = output + " " + list.get(i).getBeginColor() + "," + list.get(i).getEndColor();
                            findNextPair = list.get(i).getEndColor();
                            list.remove(i);
                            break;
                        } else {
                            output = list.get(i).getBeginColor() + "," + list.get(i).getEndColor();
                            findNextPair = list.get(i).getEndColor();
                            list.remove(i);
                            break;
                        }
                    }
                }
            } else {
                if (output != null) {
                    output = output + " " + list.get(0).getBeginColor() + "," + list.get(0).getEndColor();
                    findNextPair = list.get(0).getEndColor();
                    colorChipsMap.remove(findNext);
                } else {
                    output = list.get(0).getBeginColor() + "," + list.get(0).getEndColor();
                    findNextPair = list.get(0).getEndColor();
                    colorChipsMap.remove(findNext);
                }
            }
        } else {
            output = CANNOT_UNLOCK_MASTER_PANEL;
            flag = 1;
        }

        Log.d("Map size", String.valueOf(colorChipsMap.size()));
    }

    private void breakdownColorChips(String[] pairs) {
        ColorChipsClass colorChips;

        for (int i = 1; i < pairs.length; i++) {
            String[] beginEnd = pairs[i].split(",");

            colorChips = new ColorChipsClass();
            colorChips.setBeginColor(beginEnd[0].trim());
            colorChips.setEndColor(beginEnd[1].trim());

            ArrayList<ColorChipsClass> list;

            if (colorChipsMap.containsKey(beginEnd[0].trim())) {

                list = colorChipsMap.get(beginEnd[0].trim());
                list.add(colorChips);
                colorChipsMap.put(beginEnd[0].trim(), list);
            } else {
                list = new ArrayList<ColorChipsClass>();
                list.add(colorChips);
                colorChipsMap.put(beginEnd[0].trim(), list);
            }
        }
    }

    private void breakdownBeginAndEndMarkers(String pair) {

        String[] beginEndMarkers = pair.split(",");
        this.beginMarker = beginEndMarkers[0].trim();
        this.endMarker = beginEndMarkers[1].trim();

        findNextPair = beginMarker;
    }
}
