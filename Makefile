build:
	SEMVER=$$(gitversion /showvariable SemVer) && \
	echo "Building version: $$SEMVER" && \
	./mvnw -Drevision=$$SEMVER clean verify
