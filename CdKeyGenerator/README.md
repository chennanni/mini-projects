## What

Create a program which generates keys for an application that you may put on a CD. 
Classic example would be the keys you use for installation of a major software product from Microsoft or Adobe.

## Design

- basic: design a black box containing a series of tests, only specific input/cd-key can pass the test
- medium: encript the cd-key to make the black box harder to decript
- advanced: take the process online and build a database to store all cd-keys
  - advantage: be able to revoke invalid/used keys
  - advantage: be able to bind one key to one user/pc
  - advantage: validation happens on server, instead of local, decreases chances of decripting the system
  
<http://stackoverflow.com/questions/3002067/how-are-software-license-keys-generated>
