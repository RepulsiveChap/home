import os
from downloadsite import DownloadSite
from parser import Parser

class Wallet(object):
    def __init__(self):
        self.walletArray = [100]
        if not(os.path.isfile(".wallet")):
            self.wallet=open('.wallet', 'w')
            self.wallet.close()

    def calculateWorth(self, parser):
        self.parser = parser
        self.wallet=open('.wallet','r')
        walletlist = self.wallet.read().split('\n')
        self.wallet.close()
        walletlist.pop()
        returnValue = 0.0
        for item in walletlist:
            fin = item.find(':')
            beg = 0
            coin = ""
            numCoin = ""
            while(beg < fin):
                coin = coin + item[beg]
                beg = beg +1

            while(fin+2 < len(item)):
                numCoin = numCoin + item[fin+2]
                fin = fin +1
            coinWorth = self.parser.getValue(coin + "/") 
            coinWorth = float(coinWorth)
            numCoin = float(numCoin)
            returnValue = returnValue + (coinWorth * numCoin)
            self.walletArray.append(returnValue)

        return returnValue
    
    def editWallet(self):
        os.system("vim .wallet")
