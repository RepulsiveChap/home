class Parser(object):
    def __init__(self, site):
        self.webpage = site

    def printValue(self, name):
        final = ""
        for item in self.webpage.split("\n"):
            if name in item:
                if "price" in item:
                    final = item 

        beg = final.find('$')
        fin = final.find('<', beg)

        value = ""
        while(beg+1 < fin):
            beg = beg+1
            value = value + final[beg]
        if(len(value) == 0):
            print("No coin found")
        else: 
            print(value)



