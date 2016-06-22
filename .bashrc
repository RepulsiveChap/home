#
# ~/.bashrc
#

# If not running interactively, don't do anything
[[ $- != *i* ]] && return

#Adds color to the ls command
alias ls='ls --color=auto'
#Adds color the the grep command
alias grep='grep --color=auto'
#Refreshes the system
alias refresh='sudo pacman -Syu'
#Refreshes my ~/.Xresources
alias xup="xrdb ~/.Xresources"


#Adds username, @, hostname, :, [, directory, ], :
export PS1="\[\033[38;5;1m\]\u\[$(tput sgr0)\]\[\033[38;5;15m\]@\h:\[$(tput sgr0)\]\[\033[38;5;6m\][\w]:\[$(tput sgr0)\]\[\033[38;5;15m\] \[$(tput sgr0)\]"

#Adds my normal script directory to $PATH
export PATH=$PATH:/home/joel/Scripts

