# ColorCombinationApp 

The Challenge

You recently had a state-of-the-art security system installed in your home. The master control panel requires a series of bi-colored chips to be placed end to end in
a specific sequence in order to gain access. The security provider split up the chips and gave a random number to each of your family members. All of you must
convene in order to assemble the chips and create the correct color combination. The access panel has a channel for the security chips. On each end of the channel is
a colored marker. Chips are placed end to end such that the adjacent colors match and the starting and ending chips are color matched to the corresponding markers.

Input

The input consists of a single line indicating the beginning and ending marker colors followed by a series of chip definitions. All lines consist of a pair of color indicators;
you may use integers, strings, or characters to represent each color. For our example purposes, we will use strings.

Output

If the combination cannot be achieved by using all of the chips once and only once,then report “Cannot unlock master panel”. If the combination can be achieved,
print the chips in the order required to unlock the master control.

Solved the problem by creating an android app which takes input as the number of members of the family. Input should be given as number between
1-5. Then the app names the members with numbers. Then user has to select the begin and end marker, and then members has to arrange the bicolored chips 
in a sequence. After that when you press the next button on the actionbar, the app processes the input and tells whether the master panel can be 
unlocked or not. If it can be unlocked it gives the correct sequence of the chips. 

To solve the problem, I have used Android API and approached the problem with MVP design pattern. For testing purpose, I have used jUnit4 
framework and mockito library. I prefer using Mockito because of its simple and clean syntax which does all the work. 
The minimal syntax is designed to support the common cases very well, although the few times I needed to do something more complicated 
I found what I wanted was supported and its easy to write. 

I have used the TDD approach to solve the problem and wrote three testcases. 
