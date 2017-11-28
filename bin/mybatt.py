#!/usr/bin/python
import os, os.path
import decimal
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
    output = str(int((float(nowbat)/float(fullbat)*100)))
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
        time = float(now)/float(power)
        return time
    if state == 'Charging':
        if float(power) == 0:
            return 0
        return ((float(full-now))/float(power))


def formattime(time):
    time = time;
    timetuple = math.modf(time)
    minutes = (((timetuple[0])/10)*6)
    finh=int(timetuple[1])
    finm=int(minutes*100)
    finm = "%02d" % (finm)
    output = str(finh)+ ":"+ str(finm)
    return output



def sendnotification():
    os.system("/usr/bin/notify-send -t 0 -u normal 'Your battery level is critical'")    

fpower = power()
ffull = full()
fnow = now()
fstatus = status()
ftimeleft = timeleft(fnow, fpower, fstatus, ffull)
battery = percentage(fnow, ffull)
if ftimeleft != 0:
    formated = formattime(ftimeleft)
    final = fstatus + " " + battery + "% " + formated

else:
    final = fstatus + " " + battery + "%"




### DEBUGGING ###
# print(fancybattery)
# print(fancypercent(int(battery)))
# print(formated)
# print(battery)
# print(fstatus)






# Uncomment these two lines below to use the ttf-font-awesome output.
# fancybattery = fancypercent(battery)
# final = fancybattery + " " + formated

print(final)
