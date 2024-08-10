#!/usr/bin/env node

const fs = require('fs');
const { DOMParser, XMLSerializer } = require('xmldom');

const configFileContents = fs.readFileSync('plugin.xml', 'utf-8');

const newVersion = JSON.parse(fs.readFileSync('package.json', 'utf-8')).version;

const parser = new DOMParser();
const doc = parser.parseFromString(configFileContents, 'text/xml');
console.info(doc);
doc.documentElement.setAttribute('version', newVersion);

const serializer = new XMLSerializer();

const newDoc = serializer.serializeToString(doc);

fs.writeFileSync('plugin.xml', newDoc);
