
[![](https://jitpack.io/v/Angeschossen/UpgradeableHoppersAPI.svg)](https://jitpack.io/#Angeschossen/UpgradeableHoppersAPI)

# UpgradeableHoppersAPI
Include the API with Maven: 
```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>

<dependencies>
	<dependency>
	    <groupId>com.github.angeschossen</groupId>
	    <artifactId>UpgradeableHoppersAPI</artifactId>
	    <version>INSERT VERSION HERE</version>
	</dependency>
</dependencies>
```

Include the API with Gradle:
```groovy
repositories {
	maven { url 'https://jitpack.io' }
}
dependencies {
    compileOnly "com.github.angeschossen:UpgradeableHoppersAPI:INSERT VERSION HERE"
}
```


All methods can be found in the UpgradeableHoppersAPI class.

## Integrating your own Item Stacker plugin
1. Implement the ItemStackerIntegration interface
2. Register it in the UpgradeableHoppersAPI class
