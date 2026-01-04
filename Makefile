build:
	@SEMVER=$$(gitversion /showvariable SemVer) && \
	echo "Building version: $$SEMVER" && \
	./mvnw -Drevision=$$SEMVER clean verify

version:
	@SEMVER=$$(gitversion /showvariable SemVer) && \
    echo "Project version: $$SEMVER"
