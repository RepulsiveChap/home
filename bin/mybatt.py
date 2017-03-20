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
    output = str(int(nowbat/fullbat*100))
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



#This function is only used if I want to use another
#output with ttf-font-awesome
def fancypercent(percent):
    #     
    percent = int(percent)
    if percent >= 90:
        output = ""

    if percent < 90 and percent >= 75:
        output = ""

    if percent < 75 and percent >= 50:
        output = ""

    if percent < 50 and percent >= 25:
        output = ""

    if percent < 25:
        output = ""

    if percent < 10:
        sendnotification()
    return output


def sendnotification():
    os.system("/usr/bin/notify-send -t 0 -u normal 'Your battery level is critical'")    

fpower = power()
ffull = full()
fnow = now()
fstatus = status()
ftimeleft = timeleft(fnow, fpower, fstatus, ffull)
formated = formattime(ftimeleft)

battery = percentage(fnow, ffull)




### DEBUGGING ###
# print(fancybattery)
# print(fancypercent(int(battery)))
# print(formated)
# print(battery)
# print(fstatus)





if (int(battery) < 10 and fstatus == "Discharging"):
    sendnotification()
final = fstatus + " " + battery + "% " + formated

# Uncomment these two lines below to use the ttf-font-awesome output.
# fancybattery = fancypercent(battery)
# final = fancybattery + " " + formated

print(final)
