# renovate-sbt-artifactid-issue

This repository is a minimal example to reproduce an issue with Renovate and SBT.

Issue link:
https://github.com/renovatebot/renovate/discussions/30217

## Issue

Renovate assumes that the artifactId consists of the `{artifact_scalaVersion}` pattern. This is not always the case.
This repo demonstrates that Renovate fails to update the version of a dependency with a non-standard artifactId.

## Steps to reproduce

### Local

Simply can be reproduced by running the following command:

```bash
LOG_LEVEL=debug renovate --platform=local
```

From the logs, you can see that Renovate is resolving to the wrong artifactId due to the assumption that the artifactId
is in the `{artifact_scalaVersion}` pattern. This is not the case for the [scalacheck-shapeless](https://mvnrepository.com/artifact/com.github.alexarchambault/scalacheck-shapeless_1.16)

See from the logs that it's resolving to the wrong artifactId.

```json
{
  "datasource": "sbt-package",
  "depName": "com.github.alexarchambault:scalacheck-shapeless_1.16",
  "packageName": "com.github.alexarchambault:scalacheck-shapeless_1.16_2.13",
  "currentValue": "1.3.1",
  "registryUrls": ["https://repo1.maven.org/maven2"],
  "updates": [
    {
      "bucket": "non-major",
      "newVersion": "1.12.1",
      "newValue": "1.12.1",
      "newMajor": 1,
      "newMinor": 12,
      "newPatch": 1,
      "updateType": "minor",
      "branchName": "renovate/sbt-dependencies"
    }
  ],
  "versioning": "ivy",
  "warnings": [],
  "registryUrl": "https://repo1.maven.org/maven2",
  "homepage": "https://github.com/alexarchambault/scalacheck-shapeless",
  "dependencyUrl": "https://repo1.maven.org/maven2/com/github/alexarchambault",
  "currentVersion": "1.3.1",
  "isSingleVersion": true,
  "fixedVersion": "1.3.1"
}

```

### GitHub

TBD.
