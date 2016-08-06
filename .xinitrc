setxkbmap se
xbindkeys
xrdb ~/.Xresources

#Replaces caps to control (emacs config)
setxkbmap -option ctrl:nocaps
#setxkbmap -option ctrl:none
#Replaces caps to escape (vim config)
#setxkbmap -option caps:escape
xset r rate 200 75
source $HOME/.bashrc
exec i3
#exec startxfce4
#exec startkde
setxkbmap se
feh --bg-scale Pictures/wallpaper.png
