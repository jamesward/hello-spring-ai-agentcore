Hello Spring AI AgentCore
-------------------------

Run Locally:

1. [Create a Bedrock Bearer token](https://us-east-1.console.aws.amazon.com/bedrock/home?region=us-east-1#/api-keys/long-term/create)
2. Set the env var: `export AWS_BEARER_TOKEN_BEDROCK=YOUR_TOKEN`
3. Run the app: `./gradlew bootRun`

Run on AgentCore:
1. Install Node
2. Install `uv`
3. Deploy the agent:
    ```
    cd infra
    npx aws-cdk bootstrap
    npx aws-cdk deploy
    ```
