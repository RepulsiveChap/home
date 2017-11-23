import urllib.request
class DownloadSite(object):

    def __init__(self, url):
        self.webpage = url

    def getWebpage(self):
        site = urllib.request.urlopen(self.webpage)
        decodedSite = site.read().decode('utf-8')
        return decodedSite
