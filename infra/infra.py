import aws_cdk

from aws_cdk import (
    aws_cognito
)

from constructs import Construct

from buildpack_image_asset import BuildpackImageAsset
from bedrock_agentcore_runtime import BedrockAgentCoreRuntime


class BedrockAgentCoreStack(aws_cdk.Stack):
    def __init__(self, scope: Construct, construct_id: str, **kwargs):
        super().__init__(scope, construct_id, **kwargs)

        server_image = BuildpackImageAsset(self, "ServerImage",
                                                    source_path="../",
                                                    builder="paketobuildpacks/builder-noble-java-tiny",
                                                    run_image="paketobuildpacks/ubuntu-noble-run-tiny",
                                                    platform="linux/amd64",
                                                    default_process="web",
                                                    )

        server = BedrockAgentCoreRuntime(self, "ServerAgentCore",
                                                  repository=server_image.ecr_repo,
                                                  protocol="HTTP",
                                                  )

        server.node.add_dependency(server_image)

        aws_cdk.CfnOutput(self, "HelloSpringAIAgentRuntimeArn", value=server.resource.ref)


app = aws_cdk.App()

BedrockAgentCoreStack(app, "HelloSpringAIAgent")

app.synth()
