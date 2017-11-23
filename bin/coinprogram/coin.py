#!/usr/bin/python3
from downloadsite import DownloadSite
from parser import Parser
from wallet import Wallet
import sys





site = DownloadSite('https://coinmarketcap.com/')
decodedSite = site.getWebpage()
parser = Parser(decodedSite)
wallet = Wallet()
worth = wallet.calculateWorth(parser)
# print(worth)




#Parsing the sysargs
if len(sys.argv) == 2:
    if(sys.argv[1] != "wallet"):
        parser.printValue(sys.argv[1] + "/")
    if(sys.argv[1] == "wallet"):
        worth = wallet.calculateWorth(parser)
        print(worth)
if len(sys.argv) > 2:
    if sys.argv[1] == 'pvalue':
        parser.printValue(sys.argv[2] + "/")
if len(sys.argv) == 1:
    print("Give the program a few arguments")
    print("Example: coin pvalue bitcoin")
