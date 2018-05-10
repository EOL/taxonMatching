tests.tsv: Test parameters
	test-id	
	new-node	new-node.tsv:new-node-id	The id of the new node to compare to existing EOL pages 
	page1	dynamic-hierarchy.tsv:dh-node-id	The id of a dynamic hierarchy record that represents an existing EOL page
	page2	dynamic-hierarchy.tsv:dh-node-id	The id of another dynamic hierarchy record that represents an existing EOL page
	goal	dynamic-hierarchy.tsv:dh-node-id	The id of the dynamic hierarchy record that should be matched to the new node OR 0 if there is no match
	notes		Notes about the expected match
	
new-node.tsv: Properties of the new node to be compared to existing EOL pages
	new-node-id	
	scientificname	http://rs.tdwg.org/dwc/terms/scientificName
	rank	http://rs.tdwg.org/dwc/terms/taxonRank
	synonyms	http://rs.tdwg.org/dwc/terms/scientificName of all synonyms associated with the new node; delimiter:|
	kingdom	http://rs.tdwg.org/dwc/terms/kingdom or scientificname of http://rs.tdwg.org/dwc/terms/parentNameUsageID where parent taxonRank = kingdom
	family	http://rs.tdwg.org/dwc/terms/family or scientificname of http://rs.tdwg.org/dwc/terms/parentNameUsageID where parent taxonRank = family
	genus	http://rs.tdwg.org/dwc/terms/genus or scientificname of http://rs.tdwg.org/dwc/terms/parentNameUsageID where parent taxonRank = genus
	ancestors	canonical names of all ancestors from kingdom, phylum, class, order, family, genus and parentNameUsageID path to a rootnode; delimiter:|
	children	scientificname of all immediate children of the new node; delimiter:| 

dynamic-hierarchy.tsv: properties of the dynamic hierarchy record that represents an existing EOL page
	dh-node-id	
	scientificname	http://rs.tdwg.org/dwc/terms/scientificName
	rank	http://rs.tdwg.org/dwc/terms/taxonRank
	synonyms	http://rs.tdwg.org/dwc/terms/scientificName of all synonyms associated with the dynamic-hierarchy node in the dynamic-hierarchy resource; delimiter:|
	kingdom	scientificname of http://rs.tdwg.org/dwc/terms/parentNameUsageID where parent taxonRank = kingdom
	family	scientificname of http://rs.tdwg.org/dwc/terms/parentNameUsageID where parent taxonRank = family
	genus	scientificname of http://rs.tdwg.org/dwc/terms/parentNameUsageID where parent taxonRank = genus
	ancestors	canonical names of all ancestors of the dynamic hierarchy node from parentNameUsageID path to a rootnode; delimiter:|
	children	scientificname of all immediate children of the dynamic hierarchy node; delimiter:|
	page-other-nodes

page-other-nodes.tsv: properties of nodes that have been mapped to the same page as the dynamic hierarchy node
	other-node-id	
	scientificname	http://rs.tdwg.org/dwc/terms/scientificName
	rank	http://rs.tdwg.org/dwc/terms/taxonRank
	synonyms	http://rs.tdwg.org/dwc/terms/scientificName of all synonyms associated with the node; delimiter:|
	kingdom	http://rs.tdwg.org/dwc/terms/kingdom or scientificname of http://rs.tdwg.org/dwc/terms/parentNameUsageID where parent taxonRank = kingdom
	family	http://rs.tdwg.org/dwc/terms/family or scientificname of http://rs.tdwg.org/dwc/terms/parentNameUsageID where parent taxonRank = family
	genus	http://rs.tdwg.org/dwc/terms/genus or scientificname of http://rs.tdwg.org/dwc/terms/parentNameUsageID where parent taxonRank = genus
	ancestors	canonical names of all ancestors from kingdom, phylum, class, order, family, genus and parentNameUsageID path to a rootnode; delimiter:|
	children	scientificname of all immediate children of the node; delimiter:| 
	curated	Whether the node comes from a curated hierarchy	

