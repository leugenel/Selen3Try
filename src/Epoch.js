/**
 * Created by eugenel on 3/2/17.
 */
var webdriver = require('selenium-webdriver');

var By = require('selenium-webdriver').By;
var until = require('selenium-webdriver').until;

var driver = new webdriver.Builder().forBrowser('firefox').build();

driver.get("http://www.epochconverter.com/");

driver.manage().window().maximize();

getEpochData();
getGMT("GMT still not shown");
clickTimeStamp();
getGMT("Current: ");
getTimeZone();
getDate();
clear();
setDate();
getTimeStamp();

driver.quit();


///Functions
function getEpochData() {
    getData("ecclock", "Epoch date: ");
}

function getGMT(state) {
    getData("result1", state);
}

function clickTimeStamp() {
    epochClick("//*[@id=\"ef\"]/button[1]");
}

function getTimeZone(){
    getDatabyPath("//*[@id=\"result1\"]/a", "Your time Zone: ");
}

function getDate(){
    getAttribute("hcinput", "Year: ");
    getAttribute("mm", " Month: ");
    getAttributebyName("dd", " Day: ");
    getAttributebyName("hh", " Hour: ");
    getAttributebyName("mn", " Munites: ");
    getAttributebyName("ss", " Seconds: ");
}

function setDate(){
    setKeys("hcinput", "2017");
    setKeys("mm", "01");
    setKeysbyName("dd", "01");
    setKeysbyName("hh", "00");
    setKeysbyName("mn", "00");
    setKeysbyName("ss", "00");
}


function clear(){
    epochClick("//*[@id=\"contentcolumn\"]/div[2]/p[3]/a")
}

function getTimeStamp(){
    epochClick("//*[@id=\"hf\"]/table[3]/tbody/tr/td/button");
    getData("result2", "After update: " );
}

//Helper functions

function getData(ID, printText) {
    driver.wait(until.elementLocated(By.id(ID)), 10000, "Failed to locate").then( function(){
            driver.findElement(By.id(ID)).getText().then (
                function(txt){
                    console.log(printText+txt);
                }
            )
        }
    );
}

function getAttribute(ID, printText) {
    driver.wait(until.elementLocated(By.id(ID)), 10000, "Failed to locate").then( function(){
            driver.findElement(By.id(ID)).getAttribute("value").then (
                function(txt){
                    console.log(printText+txt);
                }
            )
        }
    );
}

function getAttributebyName(ID, printText) {
    driver.wait(until.elementLocated(By.name(ID)), 10000, "Failed to locate").then( function(){
            driver.findElement(By.name(ID)).getAttribute("value").then (
                function(txt){
                    console.log(printText+txt);
                }
            )
        }
    );
}

function getDatabyPath(ID, printText) {
    driver.wait(until.elementLocated(By.xpath(ID)), 10000, "Failed to locate").then( function(){
            driver.findElement(By.xpath(ID)).getText().then (
                function(txt){
                    console.log(printText+txt);
                }
            )
        }
    );
}

function epochClick(ID) {
    driver.wait(until.elementLocated(By.xpath(ID)), 10000, "Failed to locate").then( function(){
            driver.findElement(By.xpath(ID)).click()
        }
    );
}

function setKeys(ID, keys){
    driver.wait(until.elementLocated(By.id(ID)), 10000, "Failed to locate").then( function(){
            driver.findElement(By.id(ID)).sendKeys(keys)
        }
    );
}

function setKeysbyName(ID, keys){
    driver.wait(until.elementLocated(By.name(ID)), 10000, "Failed to locate").then( function(){
            driver.findElement(By.name(ID)).sendKeys(keys)
        }
    );
}