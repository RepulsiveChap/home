"Saft .vimrc config
"
" Enables syntax
" tester
syntax on
set tabstop=4
set shiftwidth=4
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

" set the runtime path to include Vundle and initialize
set rtp+=~/.vim/bundle/Vundle.vim
call vundle#begin()
" Keybind to toggle nerdtree
map <C-n> :NERDTreeToggle<CR>
" Keybind to switch to the next buffer
map <Tab> :bn<CR>
" Keybind to switch to the previous buffee
map <S-Tab> :bp<CR>

"nnoremap <expr> <S-l> ':%s/' . input('Search: ') . '/' . input('Replace: ') . '/g' 
" Adds the rewrite as sudo command with big W
"command W w !sudo tee % > /dev/null

" Copy paste from X
"set clipboard=unnamedplus
" change leader from \ to ,
let mapleader=","
" Esc to exit insert mode in terminal
"tnoremap <Esc> <C-\><C-n>
"Datk theme for airline
" Open find file thing
"map <C-ö> :CtrlP<CR>

" alternatively, pass a path where Vundle should install plugins
"call vundle#begin('~/some/path/here')

" let Vundle manage Vundle, required
Plugin 'VundleVim/Vundle.vim'

" The following are examples of different formats supported.
" Keep Plugin commands between vundle#begin/end.
" plugin on GitHub repo
"Plugin 'tpope/vim-fugitive'
" plugin from http://vim-scripts.org/vim/scripts.html
"Plugin 'L9'
" Git plugin not hosted on GitHub
"Plugin 'git://git.wincent.com/command-t.git'
" git repos on your local machine (i.e. when working on your own plugin)
"Plugin 'file:///home/gmarik/path/to/plugin'
" The sparkup vim script is in a subdirectory of this repo called vim.
" Pass the path to set the runtimepath properly.
"Plugin 'rstacruz/sparkup', {'rtp': 'vim/'}
" Install L9 and avoid a Naming conflict if you've already installed a
" different version somewhere else.
"Plugin 'ascenator/L9', {'name': 'newL9'}
"
"MY OWN PLUGINS
Plugin 'scrooloose/nerdtree'
Plugin 'scrooloose/syntastic'
Plugin 'tpope/vim-surround'
Plugin 'bling/vim-airline'
Plugin 'vim-airline/vim-airline-themes'
Plugin 'scrooloose/nerdcommenter'
Plugin 'kien/ctrlp.vim'
"END MY PLUGINS
set statusline+=%#warningmsg#
set statusline+=%{SyntasticStatuslineFlag()}
set statusline+=%*

let g:syntastic_always_populate_loc_list = 1
let g:syntastic_auto_loc_list = 1
let g:syntastic_check_on_open = 1
let g:syntastic_check_on_wq = 0

let g:airline_section_b = '%{strftime("%c")}'
let g:airline_section_y = 'BN: %{bufnr("%")}'
let g:airline#extensions#tabline#enabled = 1
"let g:airline_powerline_fonts = 1
let g:airline_theme='dark'
set laststatus=2
" All of your Plugins must be added before the following line
call vundle#end()            " required
filetype plugin indent on    " required
" To ignore plugin indent changes, instead use:
"filetype plugin on
"
" Brief help
" :PluginList       - lists configured plugins
" :PluginInstall    - installs plugins; append `!` to update or just :PluginUpdate
" :PluginSearch foo - searches for foo; append `!` to refresh local cache
" :PluginClean      - confirms removal of unused plugins; append `!` to auto-approve removal
"
" see :h vundle for more details or wiki for FAQ
" Put your non-Plugin stuff after this line
let g:airline_theme='simple'
hi Search cterm=NONE ctermfg=black ctermbg=lightblue
execute pathogen#infect()
""""Default: /Applications/Arduino.app/Contents/Resources/Java
"let g:vim_arduino_library_path = /usr/share/arduino/
""""Default: result of `$(ls /dev/tty.* | grep usb)`
"let g:vim_arduino_serial_port = /dev/tty*
