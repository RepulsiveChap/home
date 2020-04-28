# Safts .bashrc config
# ~/.bashrc
#

# If not running interactively, don't do anything
[[ $- != *i* ]] && return

#screenfetch
#Adds color to the ls command
#alias ls='ls --color=auto'
alias ls='ls --color=auto'
#Quick move up in working dir
alias ..='cd ..'
#Quick ls list
alias ll='ls -la'
#Adds color the the grep command
alias grep='grep --color=auto'
#Refreshes the system
alias yolo='sudo apt update && sudo apt upgrade && sudo apt dist-upgrade'
#Refreshes my ~/.Xresources
alias xup="xrdb ~/.Xresources"
#Lists only the hidden files
alias ls.="ls -d .?*"
#Install program
alias i="sudo apt install"
#Starts my brightness script
alias b="sudo /home/saft/bin/mybrightness.py"
#Starts nvimrc
#alias vim="nvim"
#Search programs
alias s="sudo apt search"
#Remove program and all config and dependencies
alias remove="sudo apt remove"
#Takes a video and streams only the sound
alias music="mpv --no-video"
#Moves to the prog directory
alias prog="cd ~/Documents/IntroFunktionellProgrammering"
#Moves to the math directory
alias math="cd ~/Documents/InledandeDiskretMatematik"
#Downloads music
alias dmusic="youtube-dl -x --audio-format vorbis --restrict-filenames"
#EMERGENCY IF FBI, NSA, FRA and CIA ARRIVES TO MY HOUSE
alias EMERGENCY_DELETE="sudo shred -v -f /dev/sda"
#Open file
alias o="vim"
#Adds username, @, hostname, :, [, directory, ], :
export PS1="\[\033[38;5;1m\]\u\[$(tput sgr0)\]\[\033[38;5;15m\]@\h:\[$(tput sgr0)\]\[\033[38;5;6m\][\w]:\[$(tput sgr0)\]\[\033[38;5;15m\] \[$(tput sgr0)\]"
#Adds my normal script directory to $PATH
#export PATH=$PATH:$HOME/bin
export PATH=$PATH:$HOME/.cabal/bin
export PATH=$HOME/bin:$PATH
EDITOR=vim

