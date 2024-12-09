from PIL import Image
from io import BytesIO
import cairosvg
import os

for file in os.listdir("."):
    if file.endswith(".webp"):
        img = Image.open(file)
        img.save(f"{file.split(".")[0]}.png")
    elif file.endswith(".svg"):
        png = BytesIO()
        cairosvg.svg2png(url=file, write_to=png)
        img = Image.open(png)
        img.save(f"{file.split(".")[0]}.png")
