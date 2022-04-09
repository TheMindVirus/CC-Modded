from PIL import Image
import os

THIS_PATH = os.getcwd()
INPUT_PATH = os.path.join(THIS_PATH, "input")
OUTPUT_PATH = os.path.join(THIS_PATH, "output")

for root, dirs, files in os.walk(INPUT_PATH):
    for file in files:
        rgb = 0x770040
        if "speaker" in file:
            rgb = 0x101010
        r = ((rgb >> 16) & 0xFF) / 0xFF
        g = ((rgb >>  8) & 0xFF) / 0xFF
        b = ((rgb      ) & 0xFF) / 0xFF

        filepath = os.path.join(root, file)
        img = Image.open(filepath).convert("RGBA")

        size = img.size[0] * img.size[1]
        data = img.getdata()
        pixels = len(data)
        newdata = [[0, 0, 0, 0]] * pixels

        for i in range(0, pixels):
            newdata[i][0] = int(data[i][0] * r)
            newdata[i][1] = int(data[i][1] * g)
            newdata[i][2] = int(data[i][2] * b)
            newdata[i][3] = int(data[i][3])
            newdata[i] = tuple(newdata[i])
        img.putdata(newdata)

        newpath = os.path.join(OUTPUT_PATH, file)
        img.save(newpath)

print("Done!")
