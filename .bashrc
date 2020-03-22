# Safts .bashrc config
# ~/.bashrc
#

# If not running interactively, don't do anything
[[ $- != *i* ]] && return

alias ls='ls --color=auto'
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
#Downloads music
alias dmusic="youtube-dl -x --audio-format vorbis --restrict-filenames"
#Adds username, @, hostname, :, [, directory, ], :
export PS1="\[\033[38;5;1m\]\u\[$(tput sgr0)\]\[\033[38;5;15m\]@\h:\[$(tput sgr0)\]\[\033[38;5;6m\][\w]:\[$(tput sgr0)\]\[\033[38;5;15m\] \[$(tput sgr0)\]"
#Adds my normal script directory to $PATH
export PATH=$HOME/bin:$PATH
export PATH=$HOME/.local/bin:$PATH
EDITOR=vim
