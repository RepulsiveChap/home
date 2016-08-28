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


def percentage(nowbat, fullbat):
    output = str(int(nowbat/fullbat*100))+"%"
    return output


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
    timetuple = math.modf(time)
    minutes = (((timetuple[0])/10)*6)
    finh=int(timetuple[1])
    finm=int(minutes*100)
    finm = "%02d" % (finm)
    output = str(finh)+ ":"+ str(finm)
    return output


fpower = power()
ffull = full()
fnow = now()
fstatus = status()
ftimeleft = timeleft(fnow, fpower, fstatus, ffull)
formated = formattime(ftimeleft)
battery = percentage(fnow, ffull)
# print(formated)
# print(battery)
# print(fstatus)
final = fstatus + " " + battery + " " + formated
print(final)
