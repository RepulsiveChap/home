#!/usr/bin/python3
from downloadsite import DownloadSite
from parser import Parser
import sys


site = DownloadSite('https://coinmarketcap.com/')
decodedSite = site.getWebpage()
a = Parser(decodedSite)

if len(sys.argv) == 2:
    a.printValue(sys.argv[1] + "/")
if len(sys.argv) > 2:
    if sys.argv[1] == 'pvalue':
        a.printValue(sys.argv[2] + "/")
if len(sys.argv) == 1:
    print("Give the program a few arguments")
    print("Example: coin pvalue bitcoin")
