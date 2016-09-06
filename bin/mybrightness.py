#!/bin/python
import time
import math
import os, os.path
import sys
DIR = '/sys/class/backlight/intel_backlight/'
change = int(sys.argv[1])

def run():
    maximum = maxbrightness()
    print("Maximum: " , maximum)
    percent = calculate(maximum) 
    print("Percent: " , percent)
    writetofile(percent)


def writetofile(percent):
    percent = str(percent)
    f = open(DIR+"brightness", "w")
    f.write(percent)

    f.close()


def calculate(maximum):
    percent = ((maximum/100)*change)
    percent = int(percent)
    return percent


def maxbrightness():
    temp = DIR+"max_brightness"
    a = open(temp, 'r')
    maxbrightness = int(a.read())
    return maxbrightness

if change > 0 and change <= 100:
    run()
else: 
    print("Bad value: ", change)
