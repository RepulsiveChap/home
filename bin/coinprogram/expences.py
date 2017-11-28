import os

class Expences(object):
    def __init__(self):
        if not(os.path.isfile("/home/saft/bin/coinprogram/.expences")):
            self.wallet=open('/home/saft/bin/coinprogram/.expences', 'w')
            self.wallet.close()

    def calculateExpences(self):
        self.expences=open('/home/saft/bin/coinprogram/.expences','r')
        final = 0
        for item in self.expences:
            final = final + float(item)

        return final
