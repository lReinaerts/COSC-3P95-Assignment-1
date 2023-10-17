from dataclasses import replace

#This method takes an input string and uses delta debugging to minimize the string to the smallest it can for a bug to be produced.
def deltaDebugging(input_str):
    n = 2
    print("Input String:" + input_str) #Print the input string
    while len(input_str) >= n: #while the length of the input string is larger or equal to the number of partitions
        length = len(input_str)
        div = length // n
        inputs = []
        x = 0
        y = div
        for i in range(n): #For i in range of the number of partitions.
            str = input_str[x:y]
            lengthstr = len(str)
            x = y
            y += div
            if len(processString(str)) == lengthstr: #If the length of the substring after being passed to proccess string is larger than the original lengh of the substring.
                input_str = input_str.replace(str, "")

        endlength = len(input_str)
        if length - endlength == 0:
            n *= 2

    print("The minimal value which produces a bug for the input string is:" + input_str)


#Proccess String Method
def processString(input_str):
    output_str = ""
    for char in input_str:
        if char.isupper():
            output_str += char.lower()
        elif char.isnumeric():
            output_str += char * 2
        else:
            output_str += char.upper()
    return output_str

deltaDebugging("8655") #Delta Debugging called