


f = open("input.txt", "r")

check_sum = 0
for line in f:
	#print line
	s = line.split()
	for i in range(len(s)):
		number = int(s[i])
		for j in range(len(s)):
			if j== i: continue
			next_number = int(s[j])
			if number % next_number == 0:
				check_sum += number/next_number 
			
			

print check_sum

