setxkbmap se
xbindkeys
xrdb ~/.Xresources
#pulseaudio --start
#Replaces caps to control (emacs config)
#setxkbmap -option ctrl:nocaps
#setxkbmap -option ctrl:none
#Replaces caps to escape (vim config)
setxkbmap -option caps:escape
xmodmap ~/.Xmodmap
xset r rate 200 75
source $HOME/.bashrc
exec i3
#sxhkd &
#exec bspwm
#exec openbox-session
#exec gnome-session
#exec startxfce4
#exec startkde
#setxkbmap se
#feh --bg-scale Pictures/wallpaper.png
#dunst
