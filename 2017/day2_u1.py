


f = open("input.txt", "r")

check_sum = 0
for line in f:
	#print line
	s = line.split()
	int_array = []
	for i in range(len(s)):
		temp = int(s[i])
		int_array.append(temp)

	int_array.sort()
	if len(int_array) > 0:
		smallest = int_array[0]
		highest = int_array[len(int_array)-1]
		check_sum += highest - smallest
print check_sum

