const assert = require('assert');

class Directory {
  constructor(exist) {
    this.exist = exist;
    this.subDir = {};
  }
  addSubDir(subDir, exist) {
    if (this.subDir[subDir]) {
      const existingDir = this.subDir[subDir];
      if (!existingDir.exist && exist) existingDir.exist = true;
      return existingDir;
    }
    const newDir = new Directory(exist);
    this.subDir[subDir] = newDir;
    return newDir;
  }
  traverse(path) {
    if (this.exist) return [path];
    return Object.keys(this.subDir).reduce((acc, subDir) => {
      acc.push(...this.subDir[subDir].traverse(`${path}/${subDir}`));
      return acc;
    }, []);
  }
}

const solution1 = (folders) => {
  const root = new Directory();

  for (let folder of folders) {
    const dirToken = folder.split('/').slice(1);
    let dirPtr = root;

    for (let dirIdx = 0; dirIdx < dirToken.length; dirIdx++) {
      const dir = dirToken[dirIdx];
      dirPtr = dirPtr.addSubDir(dir, dirIdx === dirToken.length - 1);
    }
  }
  return Object.keys(root.subDir).reduce((acc, subDir) => {
    const result = root.subDir[subDir].traverse('');
    acc.push(
      ...result.reduce((acc, path) => {
        acc.push(`/${subDir}${path}`);
        return acc;
      }, [])
    );
    return acc;
  }, []);
};

const solution2 = (folders) => {
  folders.sort();
  const folderSet = [];
  for (let folder of folders) {
    if (!folderSet.length) folderSet.push(folder);
    else if (!folder.startsWith(`${folderSet[folderSet.length - 1]}/`)) folderSet.push(folder);
  }
  return folderSet;
};

const removeSubfolders = (folders) => {
  // return solution1(folders);
  return solution2(folders);
};

assert.deepEqual(removeSubfolders(['/a', '/a/b', '/c/d', '/c/d/e', '/c/f']).sort(), ['/a', '/c/d', '/c/f'].sort());
assert.deepEqual(removeSubfolders(['/a', '/a/b/c', '/a/b/d']).sort(), ['/a'].sort());
assert.deepEqual(removeSubfolders(['/a/b/c', '/a/b/ca', '/a/b/d']).sort(), ['/a/b/c', '/a/b/ca', '/a/b/d'].sort());
assert.deepEqual(removeSubfolders(['/ah/al/am', '/ah/al']).sort(), ['/ah/al'].sort());

console.log('All test passed');
