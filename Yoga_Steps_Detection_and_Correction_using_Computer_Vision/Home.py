import tkinter as tk
from tkinter import ttk, LEFT, END
from PIL import Image, ImageTk
from tkinter.filedialog import askopenfilename
from tkinter import messagebox as ms
import cv2
import sqlite3
import os
import numpy as np
import time

from sklearn.metrics import mean_squared_error
import pandas as pd
import numpy as np

global fn
fn = ""
##############################################+=============================================================
root = tk.Tk()
root.configure(background="brown")
# root.geometry("1300x700")


w, h = root.winfo_screenwidth(), root.winfo_screenheight()
root.geometry("%dx%d+0+0" % (w, h))
root.title("Yoga Pose Detection Using Machine Learning")

# 43

# ++++++++++++++++++++++++++++++++++++++++++++
#####For background Image
image2 = Image.open('a1.jpg')
image2 = image2.resize((1530, 1000), Image.ANTIALIAS)

background_image = ImageTk.PhotoImage(image2)

background_label = tk.Label(root, image=background_image)

background_label.image = background_image

background_label.place(x=0, y=0)  # , relwidth=1, relheight=1)
#
label_l1 = tk.Label(root, text="Yoga Pose Detection Using Machine Learning",font=("Times New Roman", 35, 'bold'),
                    background="#152238", fg="white", width=50, height=2)
label_l1.place(x=0, y=0)

def help():
    frame_alpr = tk.LabelFrame(root, text=" --Yoga Poses-- ", width=900, height=550, bd=5, font=('times', 14, ' bold '),bg="SeaGreen1")
    frame_alpr.grid(row=0, column=0, sticky='nw')
    frame_alpr.place(x=450, y=120)

    image3 = Image.open('v.jpg')
    image3 = image3.resize((200, 200), Image.ANTIALIAS)
    background_image3 = ImageTk.PhotoImage(image3)
    background_label3 = tk.Label(root, image=background_image3,text="Vajrasan",compound='bottom')
    background_label3.image = background_image3
    background_label3.place(x=500, y=150)
    
    image4 = Image.open('sar.jpg')
    image4 = image4.resize((200, 200), Image.ANTIALIAS)
    background_image4 = ImageTk.PhotoImage(image4)
    background_label4 = tk.Label(root, image=background_image4,text="Sarvangasan",compound='bottom')
    background_label4.image = background_image4
    background_label4.place(x=700, y=150)
    
    
    image5 = Image.open('shi.jpg')
    image5 = image5.resize((200, 200), Image.ANTIALIAS)
    background_image5 = ImageTk.PhotoImage(image5)
    background_label5 = tk.Label(root, image=background_image5,text="Shirsasan",compound='bottom')
    background_label5.image = background_image5
    background_label5.place(x=900, y=150)
    
    image6 = Image.open('ch.jpg')
    image6 = image6.resize((200, 200), Image.ANTIALIAS)
    background_image6 = ImageTk.PhotoImage(image6)
    background_label6 = tk.Label(root, image=background_image6,text="Chakrasan",compound='bottom')
    background_label6.image = background_image6
    background_label6.place(x=1100, y=150)
    
    image7 = Image.open('s.jpg')
    image7 = image7.resize((200, 200), Image.ANTIALIAS)
    background_image7 = ImageTk.PhotoImage(image7)
    background_label7 = tk.Label(root, image=background_image7,text="Shavasan",compound='bottom')
    background_label7.image = background_image7
    background_label7.place(x=500, y=400)
    
    image8 = Image.open('g.jpg')
    image8 = image8.resize((200, 200), Image.ANTIALIAS)
    background_image8 = ImageTk.PhotoImage(image8)
    background_label8 = tk.Label(root, image=background_image8,text="Gomukhaasan",compound='bottom')
    background_label8.image = background_image8
    background_label8.place(x=700, y=400)
    
    image9 = Image.open('b.jpg')
    image9 = image9.resize((200, 200), Image.ANTIALIAS)
    background_image9 = ImageTk.PhotoImage(image9)
    background_label9 = tk.Label(root, image=background_image9,text="Bhadraasan",compound='bottom')
    background_label9.image = background_image9
    background_label9.place(x=900, y=400)
    
    image10 = Image.open('d.jpg')
    image10 = image10.resize((200, 200), Image.ANTIALIAS)
    background_image10 = ImageTk.PhotoImage(image3)
    background_label10 = tk.Label(root, image=background_image10,text="Dhanurasan",compound='bottom')
    background_label10.image = background_image10
    background_label10.place(x=1100, y=400)
    
    image11 = Image.open('a1.jpg')
    image11 = image11.resize((200, 200), Image.ANTIALIAS)
    background_image11 = ImageTk.PhotoImage(image11)
    background_label11 = tk.Label(root, image=background_image11,text="Vajrasan",compound='bottom')
    background_label11.image = background_image11
    background_label11.place(x=0, y=0)
    
#

################################$%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

def action():
   
    from subprocess import call
    call(["python","GUI_Master.py"])
    

#################################################################################################################
def window():
    root.destroy()



button1 = tk.Button(root, text="Recognize Yoga Pose",command=action, width=20, height=1, bg="#152238", fg="white",font=('times', 20, ' bold '))
button1.place(x=100, y=220)

# button2 = tk.Button(root, text="",command=XGBOOST, width=20, height=1, bg="#152238", fg="white",font=('times', 20, ' bold '))
# button2.place(x=100, y=220)

button3 = tk.Button(root, text="Help",command=help, width=20, height=1, bg="#152238", fg="white",font=('times', 20, ' bold '))
button3.place(x=100, y=320)

exit = tk.Button(root, text="Exit", command=window, width=14, height=1, font=('times', 20, ' bold '), bg="cyan",fg="white")
exit.place(x=140, y=420)

root.mainloop()