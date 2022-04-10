import os

search = "allow_disk_startup"
path = os.path.join(os.getcwd(), "..")

print("Searching for \"" + search + "\"")
print("In path \"" + path + "\"")
for root, dirs, files in os.walk(path):
    for filename in files:
        filepath = os.path.join(root, filename)
        file = open(filepath, "rb")
        data = file.read()
        file.close()
        pos = data.find(search.encode())
        if pos != -1:
            relpath = os.path.relpath(filepath)
            line = 1
            for i in range(0, pos):
                if data[i] == ord("\n"):
                    line += 1
            print(relpath + "#L" + str(line))
print("Finished Searching")
