#!/usr/bin/python3
from downloadsite import DownloadSite
from parser import Parser
from wallet import Wallet
from expences import Expences
import sys





site = DownloadSite('https://coinmarketcap.com/')
decodedSite = site.getWebpage()
parser = Parser(decodedSite)
wallet = Wallet()
worth = wallet.calculateWorth(parser)
expences = Expences()
dollar = 8.3




#One argument
if len(sys.argv) == 2:

    #Wallet, returns wallet value in dollars
    if(sys.argv[1] == "wallet"):
        worth = wallet.calculateWorth(parser)
        print(worth)

    #Edits the wallet
    elif(sys.argv[1] == "e"):
        wallet.editWallet()

    #Prints the expences in sek
    elif(sys.argv[1] == "expences"):
        print(expences.calculateExpences())

    #Subtracts the expences from the value. Prints in sek
            

    #Prints the value of the given coin in dollars
    else:
        parser.printValue(sys.argv[1] + "/")

#Two or morearguments
if len(sys.argv) > 2:
    if sys.argv[1] == 'pvalue':
        parser.printValue(sys.argv[2] + "/")

    elif(sys.argv[1] == "sum"):
        if(sys.argv[2] == "sek"):
            sumExpences = expences.calculateExpences()
            worth = wallet.calculateWorth(parser)
            worth = worth * dollar
            print(worth - sumExpences)
        elif(sys.argv[2] == "dollar"):
            sumExpences = expences.calculateExpences()
            sumExpences = sumExpences / dollar
            worth = wallet.calculateWorth(parser)
            print(worth - sumExpences)
    elif(sys.argv[1] == "wallet"):
        if(sys.argv[2] == "sek"):
            worth = wallet.calculateWorth(parser)
            worth = worth * dollar
            print(worth)
        elif(sys.argv[2] == "dollar"):
            worth = wallet.calculateWorth(parser)
            print(worth)
            pass
        else:
            print("Please enter valid currency")

    else:
        print("Please enter valid currency")

if len(sys.argv) == 1:
    print("Give the program a few arguments")
    print("Example: coin pvalue bitcoin")
