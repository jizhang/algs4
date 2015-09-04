Algorithms 4th Edition
======================

* Install `algs4` into local repo:

```bash
$ mvn install:install-file -Dfile=lib/algs4.jar -DgroupId=edu.princeton.cs -DartifactId=algs4 -Dpackaging=jar -Dversion=1.0.0
```

* Import into Eclipse as "Existing Maven Project".
* Run main class in command line:

```bash
$ mvn exec:java -Dexec.mainClass=com.shzhangji.algs4.sort.Heap
```
