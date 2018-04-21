#!/usr/bin/env node
const fs = require('fs');
const path = require('path');

/*
fs.readFile(path.resolve(__dirname, 'chuck.txt'), (error, data) => {
	const facts = data.toString().split("\n");
	const fact = facts[Math.floor(Math.random() * facts.length)];
	console.log(fact);
});
*/

const request = require('request');
const args = process.argv;
const api = 'https://api.chucknorris.io/jokes/random';
const method = 'GET';

let url = api;
let category;

if (args.length > 2) {
	category = args[2];
}

if (category) {
	url += `?category=${category}`;
}

const options = {
	url,
	method,
	headers: {
		'content-type': 'application/json'
	}
}

request(options, (error, response, body) => {
	if (!error && response.statusCode === 200) {
		console.log(`SUCCESSFUL: (${response.statusCode}) ${JSON.parse(body).value}`);
	}
});