(ns circumspec.colorize)

(def color-table
  {:red "[31m"
   :green "[32m"
   :yellow "[33m"
   :black "[0m"})

(defn str->ansi-color-str
  "Takes a string and converts it to the supplied ansi color code"
  [color]
  (str (char 27) (color-table color)))

(def *colorize* true)

(defn colorize
  "Wrap text in color if nonempty && *colorize* true, else return text."
  [text color]
  (if (and *colorize* (seq text))
    (str (str->ansi-color-str color) text (str->ansi-color-str :black))
    text))

