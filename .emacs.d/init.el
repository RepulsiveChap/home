;;; Repulsive Chaps emacs config
;;; Adds an archive of packages to install
(require 'package)
(add-to-list 'package-archives '("melpa" . "http://melpa.org/packages/"))
(package-initialize)
;;; Sets altgr+e to change inside "something"
(global-set-key (kbd "€") 'er/expand-region)
;;; Adds alt+x to be like d menu
(global-set-key (kbd "M-x") 'smex)
;;; Adds ctl+x ctrl+f to act like d menu
(ido-mode 1)
;;;Configs to remove the gui from gui emacs
(menu-bar-mode -1)
(scroll-bar-mode -1)
(tool-bar-mode -1)
(fringe-mode 0)
;;;Changes the white background to black and black text to white
;;;(add-to-list 'default-frame-alist '(foreground-color . "#ffffff"))
(load-theme 'atom-dark t) ;;;Adds a theme
;;;(add-to-list 'default-frame-alist '(background-color . "#000000"))
;;;Removes ido-mode to search other directories
(setq ido-auto-merge-work-directories-length -1)
;;;Adds line numbers
(global-linum-mode 1)
;;;Adds space between linennumber and code
(setq-default linum-format "%d ")
(custom-set-variables
 ;; custom-set-variables was added by Custom.
 ;; If you edit it by hand, you could mess it up, so be careful.
 ;; Your init file should contain only one such instance.
 ;; If there is more than one, they won't work right.
 '(custom-safe-themes
   (quote
    ("a1289424bbc0e9f9877aa2c9a03c7dfd2835ea51d8781a0bf9e2415101f70a7e" "4f0f2f5ec60a4c6881ba36ffbfef31b2eea1c63aad9fe3a4a0e89452346de278" default))))
(custom-set-faces
 ;; custom-set-faces was added by Custom.
 ;; If you edit it by hand, you could mess it up, so be careful.
 ;; Your init file should contain only one such instance.
 ;; If there is more than one, they won't work right.
 )
