# Repulsive Chap .bashrc config
# ~/.bashrc
#

# If not running interactively, don't do anything
[[ $- != *i* ]] && return

#screenfetch
#Adds color to the ls command
alias ls='ls --color=auto'
#Adds color the the grep command
alias grep='grep --color=auto'
#Refreshes the system
alias refresh='sudo pacman -Syu'
#Refreshes my ~/.Xresources
alias xup="xrdb ~/.Xresources"
#Lists only the hidden files
alias ls.="ls -d .?*"
#Install program
alias i="sudo pacman -S"
#Remove program and all config and dependencies
alias remove="sudo pacman -Rns"
#Takes a video and streams only the sound
alias music="mpv --no-video"
#Downloads music
alias dmusic="youtube-dl -x --audio-format vorbis --restrict-filenames"

#Adds username, @, hostname, :, [, directory, ], :
export PS1="\[\033[38;5;1m\]\u\[$(tput sgr0)\]\[\033[38;5;15m\]@\h:\[$(tput sgr0)\]\[\033[38;5;6m\][\w]:\[$(tput sgr0)\]\[\033[38;5;15m\] \[$(tput sgr0)\]"

#Adds my normal script directory to $PATH
export PATH=$PATH:$HOME/Scripts
