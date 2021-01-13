cli = new CliBuilder(usage: "wc [options] <file>")
cli.l "count lines"
cli.m "count characters"
cli.w "count words"
cli.h "help"

opts = cli.parse(args)
if (!opts) { return }

if (opts.arguments().size() < 1) {
   cli.usage()
   return
}

//noOptions = !opts.l && !opts.w && !opts.m
noOptions = opts.getOptions().size() == 0
totals = []

opts.arguments().each { fileName ->
   text = new File(fileName).text

   fileTotals = []
   if (opts.l || noOptions) { fileTotals << text.split("\\n").size() }
   if (opts.w || noOptions) { fileTotals << text.split("\\W").size() }
   if (opts.m || noOptions) { fileTotals << text.size() }

   println "${fileTotals.join(' ')} $fileName"

   if (totals.size() == 0) { totals = [0]*fileTotals.size() }
   fileTotals.eachWithIndex { num, index -> totals[index] += num }
}

if (opts.arguments().size() > 1) {
	println "${totals.join(' ')} total"
}
