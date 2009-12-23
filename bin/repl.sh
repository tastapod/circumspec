#!/bin/sh
CLASSPATH=classes:src:test:features

for f in lib/*.jar; do
    CLASSPATH=$CLASSPATH:$f
done

rlwrap java -cp $CLASSPATH clojure.main -i bin/repl.clj -r