{
  description = "dotnet todo sample app";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixpkgs-unstable";
    nixpkgs-master.url = "github:NixOS/nixpkgs/master";
    utils.url = "github:numtide/flake-utils";
    utils.inputs.nixpkgs.follows = "nixpkgs";
  };

  outputs = { self, nixpkgs, nixpkgs-master, utils, ... }@inputs:
    utils.lib.eachDefaultSystem (system:
      let
        pkgs = import nixpkgs {
          config.allowUnfree = true;
          inherit system;
        };
        pkgsUnstable = import nixpkgs-master {
          config.allowUnfree = true;
          inherit system;
        };
      in {
        devShell = pkgs.mkShell rec {
          name = "dotnettodo";
          packages = with pkgs; [
            dotnet-sdk
            dotnet-runtime
            dotnet-aspnetcore
            vscode-extensions.ms-dotnettools.csharp
            vscode
            dotnetPackages.Nuget
          ];
        };
      });
}
