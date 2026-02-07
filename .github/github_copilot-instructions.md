# Project Conventions

## Commit Messages
This project uses Conventional Commits validated by pre-commit hooks.
Format: `<type>(<scope>): <description>`

Types: feat, fix, docs, style, refactor, test, chore

## Versioning
- GitVersion automatically calculates versions
- Maven uses `${revision}${changelist}` format
- Never manually set versions in pom.xml

## When helping developers:
- Suggest conventional commit messages based on their changes
- Explain GitVersion's calculated version if asked
- Remind them that tooling will validate their commits