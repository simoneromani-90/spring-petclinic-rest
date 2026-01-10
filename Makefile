build:
	@SEMVER=$$(gitversion /showvariable SemVer) && \
	echo "Building version: $$SEMVER" && \
	./mvnw -Drevision=$$SEMVER clean verify

version:
	@SEMVER=$$(gitversion /showvariable SemVer) && \
    echo "Project version: $$SEMVER"

verify-commit:
	@echo "Validating last commit message..."
	@echo $$(git log -1 --pretty=%B) | npx commitlint
