val forceUpdate = false


name = "pho"
uribase = "http://pho.nprod.net/"
version = "0.0.1"
rootDirectory = "src/ontology"
buildDirectory = "build"
outputDirectory = "output"
cacheDirectory = "cache"

catalog = "catalog-v001.xml" // This is the default in robot anyway
termsListsPath = "terms" // Path of term lists

mainSource = "main-edit.owl"
extraSources = setOf()

preseedGeneration = true

formats = setOf("json")

prefix("PHO", uribase)
prefix("OBI", "http://purl.obolibrary.org/obo/OBI_")
prefix("UBERON", "http://purl.obolibrary.org/obo/UBERON_")

importAndExtract(
    name = "bfo",
    location = "http://purl.obolibrary.org/obo/bfo.owl",
    terms = "bfo_terms.txt",
    forceUpdate = forceUpdate
)

importAndExtract(
    name = "ro",
    location = "http://purl.obolibrary.org/obo/ro.owl",
    terms = "ro_terms.txt",
    forceUpdate = forceUpdate
)

importAndExtract(
    name = "eco",
    location = "http://purl.obolibrary.org/obo/eco.owl",
    terms = "eco_terms.txt",
    forceUpdate = forceUpdate
)

importAndExtract(
    name = "obi",
    location = "http://purl.obolibrary.org/obo/obi.owl",
    terms = "obi_terms.txt",
    forceUpdate = forceUpdate
)

importAndExtract(
    name = "uberon",
    location = "http://purl.obolibrary.org/obo/uberon.owl",
    terms = "uberon_terms.txt",
    forceUpdate = forceUpdate
)

importAndExtract(
    name = "cl",
    location = "http://purl.obolibrary.org/obo/cl.owl",
    terms = "cl_terms.txt",
    forceUpdate = forceUpdate
)

importAndExtract(
    name = "ncit",
    location = "http://purl.obolibrary.org/obo/ncit.owl",
    terms = "ncit_terms.txt",
    forceUpdate = forceUpdate
)

module("administration-methods.tsv")
module("evidence.tsv")
module("compound.tsv")
module("organism.tsv")
module("material-processing.tsv")
module("route-of-administration.tsv", listOf("administration-methods.tsv"))
module("activity.tsv")
module("property.tsv")
module("qualitative-result.tsv")
// TODO: Convert
//module("target-organism.tsv")
// A3
// citation info (import CiTo)
// compound info?
// organism info?
// pharmacy info?
// country and geographical areas
// pathological systems
// worktypes extract
// part conditions
// extract

buildFull(name = "full", reasoning = true)
buildBase(name = "base", reasoning = false)