from PIL import Image
import os

for file in os.listdir("."):
    if file.endswith(".jpg"):
        img = Image.open(file)
        img.save(f"{file.split(".")[0]}.png")
