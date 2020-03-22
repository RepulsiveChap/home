"Saft .vimrc config
"
syntax on set tabstop=4
set shiftwidth=4
" Used to fix the SHIFT-o bug thingy
set timeout timeoutlen=5000 ttimeoutlen=100
set softtabstop=4
set expandtab
" Enables row numer
set number
" Enables things
filetype plugin indent on
filetype plugin on
set hidden
set clipboard+=unnamedplus
color desert
"Use :set paste if you want to copy text
"With more than 1 line without fucking it up
set nocompatible              " be iMproved, required
filetype off                  " required
" Keybind to switch to the next buffer
map <Tab> :bn<CR>
" Keybind to switch to the previous buffee
map <S-Tab> :bp<CR>
" Setting leader key
let mapleader=","
