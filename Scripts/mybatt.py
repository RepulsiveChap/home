#!/bin/python
import os, os.path
import math
import time

DIR = '/sys/class/power_supply/'
files = os.listdir(DIR)
bats = len(files)-1


def power():
    power = 0;
    for num in range(0, bats):
        # print(num)
        temp = DIR+"BAT"+str(num)+"/power_now"
        a = open(temp, 'r')
        power = power + int(a.read())
    return power


def full():
    full = 0;
    for num in range(0, bats):
        temp = DIR+"BAT"+str(num)+"/energy_full"
        a = open(temp, 'r')
        full = full + int(a.read())
    return full

def now():
    now = 0;
    for num in range(0, bats):
        temp = DIR+"BAT"+str(num)+"/energy_now"
        a = open(temp, 'r')
        now = now + int(a.read())
    return now

def status():
    output = ''
    status = []
    for num in range(0, bats):
        temp = DIR+"BAT"+str(num)+"/status"
        a = open(temp, 'r')
        b = a.read()
        status.append(b)
    
    if 'Discharging\n' in status:
        output = 'Discharging' 
        return output
    if 'Charging\n' in status: 
        output = 'Charging'
        return output
    else:
        output = 'Charging'
        return output

def timeleft(now, power, state, full):
    if state == 'Discharging':
        time = 0;
        time = now/power
        return time
    if state == 'Charging':
        return ((full-now)/power)


def formattime(time):
    print(time)
    timetuple = math.modf(time)
    minutes = (((timetuple[0])/10)*6)
    finh=int(timetuple[1])
    finm=int(minutes*100)
    output = str(finh)+ ":"+ str(finm)
    return output
while True:
    fpower = power()
    ffull = full()
    fnow = now()
    fstatus = status()
    ftimeleft = timeleft(fnow, fpower, fstatus, ffull)
    formated = formattime(ftimeleft)
    print(formated)
    time.sleep(1)
