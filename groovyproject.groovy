import static groovy.io.FileType.FILES

def dir = new File(".");
def files = [];
dir.traverse(type: FILES, maxDepth: 0) { files.add(it) };