## Introduction to
![Git Logo](/img/Git-Logo-1788C.png)
#### June 26, 2013
#### By Brian Jesse

---

### Git Philosophy
* Speed
* Simple design
* Strong support for non-linear development (thousands of parallel branches)
* Fully distributed
* Able to handle large projects like the Linux kernel efficiently (speed and data size)
* Strong data integrity

---

### What we'll cover
* Installation
* Setup and configuration
* Initializing a repository
* Staging files
* Status and log
* Ignoring files
* Committing files
* Branching
* Merging branches
* Tagging
* Remote repositories

---

### Getting Started
* Linux installation: 

  - Red Hat

        sudo yum install git-core

  - Debian

        sudo apt-get install git

* OSX installation:
  - Standard installation

    [`http://code.google.com/p/git-osx-installer`](http://code.google.com/p/git-osx-installer)

  - With Macports:

        sudo port install git-core +svn +doc +bash_completion +gitweb

* Windows installation:

  [`http://msysgit.github.com/`](http://msysgit.github.com/)

--

### Git Setup
* Identity

      $ git config --global user.name "Brian Jesse"
      $ git config --global user.email brianj@wolfram.com

* Editor

      $ git config --global core.editor vim

* Diff Tool

      $ git config --global merge.tool vimdiff

* Test settings

      $ git config --list
      user.name=Brian Jesse
      user.email=brianj@wolfram.com
      diff.tool=vimdiff
      core.editor=vim

* CLI arguments

  - `--global` will modify for the current user
  - `--system` will modify for the entire system

--

### Configuration Files
* Local:

  `.git/config`

*  User: 

  `~/.gitconfig` <span style="font-size:0.7em;">(`%USERPROFILE%/.gitconfig` in windows)</span>

* Global: 

  `/etc/gitconfig`

\* *Configuration directive priority is in this order*

--

### Getting Help

    $ git help <verb>
    $ git <verb> --help
    $ man git-<verb>

---

### Initializing a repository 

    $ git init

* This creates a .git folder in the current directory.
* Git only requires one folder at the root of the project
* The .git folder contains the whole repository and history

--

### Staging files

    $ git add .
    $ git add *.clj
    $ git add README

* This has to be done before every commit if you wish to use the staging area
* You only have to do this when you want the repository to track a new file if you use the `-a` option when committing.

--

### Status and log

* Status

      $ git status
      # On branch master
      # Changes not staged for commit:
      #   (use "git add <file>..." to update what will be committed)
      #   (use "git checkout -- <file>..." to discard changes in working directory)
      #
      #	modified:   resources/public/md/gittalk.md
      #
      no changes added to commit (use "git add" and/or "git commit -a")

* Log

      $ git log -1
      commit 1a071baaf24488663ca7242937abbba2c21c714e
      Author: Brian Jesse <brianj@wolfram.com>
      Date:   Tue Jun 25 14:16:41 2013 -0500

          Moved app to Reveal.js

  - Log will take a number as an argument (the number of log messages to print)

--

### Ignoring files

* put a .gitignore file in the project root

      $ cat .gitignore
      /target
      /lib
      /classes
      /checkouts
      pom.xml
      *.jar
      *.class
      /.lein-*
      /.env
      *.log

* This file should be committed along with other files to your repository and shared among other repositories
* The .gitignore file will accept wildcard syntax and basic regex
* This will silence any status messages for untracked files that you do not want to add.

--

### Committing to the repository

    $ git commit -m 'Finished getting started'
    [master a62f5ca] Finished getting started
     1 file changed, 211 insertions(+), 3 deletions(-)

  - This does not put your data on the server
  - The `-a` option tells git to automatically add all modified and deleted files but will not add new ones
  - A commit is a snapshot of the entire repository (in contrast to CVS where you version and commit individual files)

---

### Branching

* Branches are a collection of commits
* They are really cheap to use and quick to set up
* You should use branches often and for individual features/issues
* Checking out a new branch

      $ git checkout -b brian
      M	resources/public/md/gittalk.md
      Switched to a new branch 'brian'

* Checking out an existing branch

      $ git checkout master
      Switched to branch 'master'

--

### Merging branches 

    $ git checkout brian
    Switched to branch 'brian'
    $ git merge master
    Updating 1a071ba..a62f5ca
    Fast-forward
     resources/public/md/gittalk.md |  214 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++---
     1 file changed, 211 insertions(+), 3 deletions(-)


* Managing merge conflicts
  - Git will create a new commit when merge conflicts occur
  - Any files that now have merge conflicts will have resolution markers in them
  - Git will also add local, remote, and base versions of the file for you to diff against
  - When you are satisfied with the merge run

        $ git add <filename>
        $ git commit

--

### Tagging

    $ git tag reveal-move 1a07
    $ git log reveal-move -1
    commit 1a071baaf24488663ca7242937abbba2c21c714e
    Author: Brian Jesse <brianj@wolfram.com>
    Date:   Tue Jun 25 14:16:41 2013 -0500

        Moved app to Reveal.js

* Tag a commit by referring to part of its SHA-1 hash id
* Git tags are pointers to a commit
* Can be treated as branches in many ways
* Should not be used for parallel development but should be used for tracking release versions and architectural overhauls.

---

### Remote repositories

* Clone via SSH

      $ git clone brianj@brianjlx:~/Projects/gittalk.git

* Clone via GIT protocol

      $ git clone git://github.com/bajesse/gittalk.git

* Clone via HTTPS

      $ git clone https://bitbucket.org/bajesse/gittalk.git

* Clone via filesystem

      $ git clone /home/brianj/Projects/gittalk

--

### Pushing local commits to a remote repository

    $ git push origin master

* This will push the branch "master" to the remote server "origin" 
* You must have write access to the remote repository
* This will only work if the branch you are pushing to is not checked out in the remote working directory
* When creating central remote repositories it makes more sense to either create or clone a repository with the `--bare` option so there is no working directory.

--

### Pulling changes from a remote repository

    $ git pull origin master

* this will initiate a merge with the content from the "master" branch on the remote repository

    $ git fetch

* this loads all repository data from a remote server but will not initiate a merge.

--

### Remote Management

    $ git remote -v
    origin	git@github.com:bajesse/gittalk.git (fetch)
    origin	git@github.com:bajesse/gittalk.git (push)

* add a new remote repository

      $ git remote add brianjlx brianj@brianjlx:Projects/gittalk

* remove a remote repository

      $ git remote rm brianjlx

---

### Resources

* Pro Git (Book)
  - Free online [`http://git-scm.com/book`](http://git-scm.com/book)

* Try git online
  - [`http://try.github.io/levels/1/challenges/1`](http://try.github.io/levels/1/challenges/1)

* Git Immersion
  - [`http://gitimmersion.com/lab_01.html`](http://gitimmersion.com/lab_01.html)

---

# THE END

---

### Advanced Concepts
* Rebasing
  > "If you treat rebasing as a way to clean up and work with commits before you push them, and if you only rebase commits that have never been available publicly, then you’ll be fine. If you rebase commits that have already been pushed publicly, and people may have based work on those commits, then you may be in for some frustrating trouble."
